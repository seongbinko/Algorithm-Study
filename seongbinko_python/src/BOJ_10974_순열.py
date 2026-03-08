
def 순열(level):
	global choose
	if level == R:

		print(' '.join(map(str,choose)))
		return

	for i in range(0,N):
		if check[i] == True:
			continue
		choose.append(lst[i])
		check[i] = True
		순열(level+1)
		check[i] = False
		choose.pop()	

N = int(input())
R = N
lst = [i+1 for i in range(N)]
choose = []
check = [False for i in range(N)]
순열(0)