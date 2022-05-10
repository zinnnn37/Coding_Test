#include <stdio.h>

int main() {
    int n, max = 0;
    float sum = 0;
    float arr[1000] = { 0, };
    int i = 0;

    scanf("%d", &n);

    while (i < n) {
        scanf("%f", &arr[i]);
        if (max < arr[i]) max = arr[i];
        i++;
    }
    i = 0;
    while (i < n) {
        sum += (arr[i] / max) * 100;
        i++;
    }
    printf("%f", sum / n);
    return 0;
}