package algoritmos.algoritmos;

public class NaivOnArray {

	public long[][] naivOnArray(long a[][], long b[][], long result[][], int n, int p, int m){

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				result[i][j] = 0l;
				for (int k = 0;  k < p; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}

}
