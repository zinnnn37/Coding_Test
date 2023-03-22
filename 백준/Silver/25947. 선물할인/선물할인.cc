#include <iostream>
#include <algorithm>
#include <vector>

int main()
{
    int start = 0, end = 0;
    int n, b, a;
    long long sum = 0;

    std::cin >> n >> b >> a;
    
    std::vector<int> p(n);
    
    for(int i=0; i<n; ++i)
        std::cin >> p[i];
    
    std::sort(p.begin(), p.end());
    
    
    
    for(; end<a; ++end)
    {
        sum += p[end]/2;
        
        if(sum > b)
        {
            std::cout << end;
            return 0;
        }
    }
    
    for(; end<n; ++end)
    {
        sum = sum + p[start]/2;
        sum = sum + p[end]/2;
        ++start;
        
        if(sum > b)
        {
            std::cout << end;
            return 0;
        }
    }
    
    std::cout << end;
    
    return 0;
}
