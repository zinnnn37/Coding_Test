#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int	is_valid(int i, int* brd)
{
	for (int j = 0; j < i; j++)
		if (brd[i] == brd[j] || abs(i - j) == abs(brd[i] - brd[j]))
			return (0);
	return (1);
}

int	n_queen(int i, int n, int cnt, int* brd)
{
	if (i == n)
	{
		cnt += 1;
		return (cnt);
	}

	int q = 0;
	while (q < n)
	{
		brd[i] = q;
		q++;
		if (is_valid(i, brd))
			cnt = n_queen(i + 1, n, cnt, brd);
	}
	return (cnt);
}

int	main()
{
	int	n;
	int* brd;
	
	scanf("%d", &n);
	brd = (int*)malloc(sizeof(int) * n);
	if (!brd)
		return (0);
	memset(brd, 0, sizeof(int) * n);
	printf("%d", n_queen(0, n, 0, brd));
	free(brd);
	return (0);
}