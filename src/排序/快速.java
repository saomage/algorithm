package 排序;

import java.util.Comparator;

public class 快速<T> {
	private Comparator<T> comp;

	public 快速(Comparator<T> comp) {
		this.comp = comp;
	}
	public void sort(T[] x){
		sort(x,0,x.length-1);
	}
	public void sort(T[]x,int start,int end){
		if(end>start){
			int a1=start;int a2=start;int b=end;
			while(b>a1){
				if(comp.compare(x[a1], x[a1+1])<0){
					exchange(x,a1+1,b--);
				}else if(comp.compare(x[a1], x[a1+1])>0){
					exchange(x,a2,a1+1);
					a1++;a2++;
				}else{
					a1++;
				}
			}
			sort(x,start,a2-1);
			sort(x,b+1,end);
		}
	}
	public void exchange(T[] x,int a,int b){
		T c=x[a];x[a]=x[b];x[b]=c;
	}
}
