
def merge_sort(arr):# ordenar el arreglo 
    if len(arr) < 2:
        return arr  
    
    mid = len(arr) // 2 # El arreglo se divide para obtener un punto medio(division entera)
    left = merge_sort(arr[:mid])   # Llama recursivamente a la mitad izquierda ()hasta que este ordenada o quede solo un numero
    right = merge_sort(arr[mid:])  

   
    sorted_arr = [] # Combina las dos mitades de manera ordenada
    i = j = 0 #Indices para recorrer las mitades 
    while i < len(left) and j < len(right):#Compara elementos mientras haya elementos en las dos partes 
        if left[i] <= right[j]:#Si el elemento left es menor o igual al right 
            sorted_arr.append(left[i])#se agrega en esta linea 
            i += 1 #Se incrementa el indice i
        else:
            sorted_arr.append(right[j])
            j += 1

    # Agrega los elementos restantes de left y right
    sorted_arr.extend(left[i:])
    sorted_arr.extend(right[j:])
    
    return sorted_arr


cantidad = int(input("Ingresa la cantidad de numeros a ordenar:  "))
arr = []

for i in range(cantidad):
    numero = int(input(f"Ingresa el numero {i+1}: "))
    arr.append(numero)


arr = merge_sort(arr)
print("Array ordenado:", arr)
