#include <iostream>

int main()
{
    int n, k, tmp, cnt, ans = 0;

    std::cin >> n >> k;

    while (n > k)
    {
        cnt = 0;
        tmp = n;

        while (tmp > 0)
        {
            if (tmp % 2 != 0)
                cnt++;

            tmp /= 2;
        }
        if (cnt <= k)
            break;
        n++;
        ans++;
    }

    std::cout << ans;
}