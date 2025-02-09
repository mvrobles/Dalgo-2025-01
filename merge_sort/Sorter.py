import sys

def merge_sort(arr: list, left: int, right: int) -> None:
    if left < right:
        mid = (left + right) // 2
        merge_sort(arr, left, mid)
        merge_sort(arr, mid + 1, right)
        merge(arr, left, mid, right)

def merge(arr: list, left: int, mid: int, right: int) -> None:
    n1 = mid - left + 1
    n2 = right - mid

    L = []
    R = []

    for i in range(n1):
        L.append(arr[left + i])
    for i in range(n2):
        R.append(arr[mid + 1 + i])

    i = 0
    j = 0
    k = left
    while i < n1 and j < n2:
        if L[i] < R[j]:
            arr[k] = L[i]
            i += 1
        else:
            arr[k] = R[j]
            j += 1
        k += 1

    while i < n1:
        arr[k] = L[i]
        i += 1
        k += 1

    while j < n2:
        arr[k] = R[j]
        j += 1
        k += 1

def main():
    input_file = sys.argv[1] if len(sys.argv) > 1 else None
    output_file = sys.argv[2] if len(sys.argv) > 2 else None
    
    if input_file:
        f = open(input_file, 'r')            
        n_cases = int(f.readline())
    else:
        n_cases = int(sys.stdin.readline())
    
    results = []
    for _ in range(n_cases):
        line = f.readline() if input_file else sys.stdin.readline()
        arr = list(map(int, line.strip().split(" ")))
        merge_sort(arr, 0, len(arr) - 1)
        results.append(" ".join(map(str, arr)))
    
    if input_file: 
        f.close()

    if output_file:
        with open(output_file, 'w') as f:
            f.write("\n".join(results))
    else:
        print("\n".join(results))

if __name__ == "__main__":
    main()
