

def comb(index, level):
	global choose, S, k
	# 6개 고르면 종료
	if level == 6:
		for u in choose:
			print(u, end=' ')
		print()
		return

	for i in range(index, k):
		choose.append(S[i])
		comb(i+1, level+1)
		choose.pop()


while True:
	I = list(map(int, input().split()))
	k = I[0]
	S = I[1:]
	choose = []
	if k == 0:
		break
	comb(0,0)
	print()