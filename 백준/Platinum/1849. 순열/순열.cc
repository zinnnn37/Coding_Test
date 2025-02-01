#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int N, idx, arr[100010];
struct seg {
	int tree[400040], start=1;
	void init() {
		scanf("%d", &N);
		memset(tree, 0, sizeof(tree));
		for (; start < N; start <<= 1);
		for (int i = 0; i < N; i++)
			tree[i + start] = 1;
		for (int i = start - 1; i; i--)
			tree[i] = tree[i * 2] + tree[i * 2 + 1];
	}
	void update(int i) {
		do {
			tree[i]--;
		} while (i >>= 1);
	}
	int query(int val, int n, int l, int r) {
		if (l == r) return l;
		int mid = (l + r) / 2;
		if (tree[n * 2] >= val) return query(val, n * 2, l, mid);
		return query(val-tree[n*2], n * 2 + 1, mid + 1, r);
	}
	int query(int val) { return query(val, 1, 0, start-1); }
}seg;

int main() {
	//freopen("input.txt", "r", stdin);
	seg.init();
	for (int i = 1; i <= N; i++) {
		scanf("%d", &idx);
		int q = seg.query(idx+1);
		arr[q] = i;
		seg.update(q+seg.start);
	}

	for (int i = 0; i < N; i++)
		printf("%d\n", arr[i]);
	return 0;
}