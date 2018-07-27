package 排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 归并<T>{
	private Comparator<T> comp;
	public 归并(Comparator<T> comp) {
		this.comp = comp;
	}
	public static void main(String[] args) {
		Integer[] a={9,8,7,6,5};
		归并<Integer> x=new 归并<Integer>(new Comparator<Integer>() {
			
			public int compare(Integer o1, Integer o2) {
				return o1<o2?-1:(o1>o2?1:0);
			}
		});
		x.sort(a);
		for (Integer integer : a) {
			System.out.println(integer);
		}
	}
	public void sort(T[] a){
		sort(a,0,a.length-1);
	}
	public void sort(T[] a,int start,int end){
		if(end-start<2){
			if(comp.compare(a[start], a[end])>0){
				exchange(a, start, end);
			}
		}else{
			int mid=(start+end)/2;
			sort(a,start,mid);
			sort(a,mid+1,end);
			merge(a,start,end,mid);
		}
	}
	public void merge(T[] a,int start ,int end,int mid) {//������ֳɡ�start��mid����mid+1,end��
		int x=start ;int y=mid+1;
		int index=start;
		List<T> list=new ArrayList<T>(end+1);
		for (int i = start; i <= end; i++) {
			list.add(i,a[i]);
		}
		while(x<=mid&&y<=end){
			if(comp.compare(list.get(x),list.get(y))<0){
				a[index++]=list.get(x++);
			}else if(comp.compare(list.get(x), list.get(y))>0){
				a[index++]=list.get(y++);
			}else{
				a[index++]=list.get(x++);
				a[index++]=list.get(y++);
			}
		}
		if(x<=mid){
			while(x<=mid){
				a[index++]=list.get(x++);
			}
		}else if(y<=end){
			while(y<=end){
				a[index++]=list.get(y++);
			}
		}
	}
	public static <T> void exchange(T[] a,int x,int y){
		T b=a[x];a[x]=a[y];a[y]=b;
	}
}
