const arr = [0, 2, 1, 5, 9, 3, 4, 6, 7, 8]

for (let i = 0; i < arr.length; i++) {
    for (let j = 0; j < arr.length - 1; j++) {
        if(arr[j] > arr[j+1]){
            const tmp = arr[j]
            arr[j] = arr[j+1]
            arr[j+1] = tmp
        }
    }
}
