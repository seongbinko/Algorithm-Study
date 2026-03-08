N = 10
R = 2
choose = []
check = [False for i in range(N)]
lst = [1,2,3,4,5,6,7,8,9,10]


def 순열(level):
	if level == R:
		print(choose)
		return

	for i in range(0,N):
		if check[i] == True:
			continue
		choose.append(lst[i])
		check[i] = True
		순열(level+1)
		check[i] = False
		choose.pop()	

순열(0)