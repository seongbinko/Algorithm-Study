
N = int(input())
arr = [-1] * (N + 1)

def pibonacci(N):
	if N == 0:
		return 0
	if N == 1:
		return 1
	return pibonacci(N-1) + pibonacci(N-2)

def pibonacci2(N):
	if N == 0:
		arr[0] = 0
		return arr[0]
	if N == 1:
		arr[1] = 1
		return arr[1]

	if arr[N] == -1:
		arr[N] = pibonacci2(N-1) + pibonacci2(N-2)
	return arr[N]

def pibonacci3(N):
	if arr[N] != -1:
		return arr[N]
	arr[N] = pibonacci3(N-1) + pibonacci3(N-2)
	return arr[N]





print(pibonacci(N))
print("============================")
pibonacci2(N)
print(arr)
print(arr[N])
