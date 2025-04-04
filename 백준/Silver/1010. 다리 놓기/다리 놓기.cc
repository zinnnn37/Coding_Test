#include <stdio.h>
int main()
{
	int t, pas[31][31];
	scanf("%d", &t);

	pas[0][0] = 1;
	for (int i = 1; i <= 30; i++)
	{
		pas[i][0] = 1;
		for (int j = 1; j <= i; j++)
		{
			pas[i][j] = pas[i - 1][j - 1] + pas[i - 1][j];
		}
	}

	for (int i = 1; i <= t; i++)
	{
		int a, b;
		scanf("%d %d", &a, &b);
		printf("%d\n", pas[b][a]);
	}

	return 0;
}