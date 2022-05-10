#include <stdio.h>

int main(){
    int n, i=0, sum = 0;
    scanf("%d", &n);
    int num = n;
    while(i<n){
        sum += num;
        num--;
        i++;
    }
    printf("%d", sum);
    return 0;
}