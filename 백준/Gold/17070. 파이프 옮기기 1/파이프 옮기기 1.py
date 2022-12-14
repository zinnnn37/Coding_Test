from collections import deque
import sys
input = lambda: sys.stdin.readline().rstrip()

def pipe():
	dp[0][0][1] = 1
	for i in range(2, n):
		if house[0][i] == 0:
			dp[0][0][i] = dp[0][0][i-1]
			# 가장 윗 줄은 가로로 쭉 갈 수 있기 때문에 모두 1
	for i in range(1, n):
		for j in range(2, n):
			if house[i][j] == 0: # 이동하려는 곳이 벽이 아닐 때
				if house[i-1][j] == 0 and house[i][j-1] == 0:
				# 대각선으로 이동하는 경우
					dp[2][i][j] = dp[0][i-1][j-1] + dp[1][i-1][j-1] + dp[2][i-1][j-1]
					# 가로, 세로, 대각선 모양 모두에서 대각선으로 이동할 수 있음
					# 이전에 있었던 곳(대각선 위[i-1][j-1])의 모든 경우의 수를 합한 것이 경로 수
				dp[0][i][j] = dp[0][i][j-1] + dp[2][i][j-1]
				# 가로로 이동하는 경우 이전 위치의 가로 + 대각선
				dp[1][i][j] = dp[1][i-1][j] + dp[2][i-1][j]
				# 세로로 이동하는 경우 이전 위치의 세로 + 대각선
	print(dp[0][n-1][n-1] + dp[1][n-1][n-1] + dp[2][n-1][n-1])
	# (n, n)의 모든 경우의 수를 출력하면 가능한 경로의 수
if __name__ == '__main__':
	n = int(input())
	house = [list(map(int, input().split())) for _ in range(n)]
	dp = [[[0] * n for _ in range(n)] for _ in range(3)]
	# [가로, 세로, 대각선 중 어느 곳으로 이동했는지 여부(각 0, 1, 2)][x][y]
	pipe()