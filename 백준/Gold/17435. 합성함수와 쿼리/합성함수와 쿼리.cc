#include <iostream>
#include<vector>
#include <algorithm>
#include<cmath>
#include<queue>
#include<map>
using namespace std;
const int level = 19;
const int MAX = 500001;
int arr[MAX][level];

int M, Q;

int digit(int n)
{
	int ret = 0;
	while (n % 2 == 0)
	{
		n /= 2;
		++ret;
	}
	return ret;
}
int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);

	cin >> M;
	for (int i = 1; i <= M; i++)
		cin >> arr[i][0];
	for (int j = 1; j < level; j++)
		for (int i = 1; i <= M; i++)
			arr[i][j] = arr[arr[i][j - 1]][j - 1];
	cin >> Q;
	for (int i = 0; i < Q; i++)
	{
		int n, x;
		cin >> n >> x;
		while (n)
		{
			x = arr[x][digit(n)];
			n &= (n - 1);
		}
		cout << x << "\n";
	}
	
}