#include <stdio.h>

int main(){
    int n, x, i = 0, a;
    scanf("%d %d", &n, &x);
    
    while (i < n){
        scanf("%d", &a);
        if (a < x)
            printf("%d ", a);
        i++;
    }
    return 0;
}