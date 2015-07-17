import java.io.*;
import java.util.Arrays;
public class ExtractAPs {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		String in = br.readLine();
		String inp[] = in.split("\\s+");
		int len = inp.length;
		int a[] = new int[len];
		for (int i = 0; i < len; i++) {
			a[i] = Integer.parseInt(inp[i]);	}
		Arrays.sort(a);
		int b[] = new int[len];
		System.arraycopy(a, 0, b, 0, len);
		perm(b, 0, len, m);	}
		public static void perm(int b[], int i, int len, int m) {
		int t = len / m;
		if( (i-1)%t == 0){
			if(!inOrder(t,i+1,b) || !inAp( (i+1)/t,b,t ) ){
				return;}	}
		if (i == len) {
			if (inOrder(t, len, b) && inAp(m, b, t) ) {
				String ans = "";
				for (int p = 0; p < len; p++) {
					ans += b[p] + " ";}
				System.out.println(ans.trim());
				System.exit(0);
				}}
		for (int j = i; j < len; j++) {
			swap(b, j, i);
			perm(b, i + 1, len, m);
			swap(b, j, i);		}
		}
	public static boolean inOrder(int t,int len,int b[]){
		int c = b[0];
		for (int j = t; j < len; j += t) {
			if (b[j] >= c) {
				c = b[j];	} 
			else {
				return false;	}	}
		return true;}
	public static boolean inAp(int m,int b[],int t){
		for (int j = 0; j < m; j++) {
			for (int k = j * t + 1; k < j * t + t - 1; k++) {
				if (b[k] - b[k - 1] != b[k + 1] - b[k]){
					return false;}
				else if (b[k - 1] > b[k] || b[k] > b[k + 1]) {
					return false;}}}
		return true;	}
	public static void swap(int b[], int i, int j) {
		int temp = b[i];
		b[i] = b[j];
		b[j] = temp;	}	}
