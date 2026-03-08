def if_possible(): # 모음의갯수 최소 1개, 자음의 갯수 최소 2개 이상이어야한다.
	global R, N, choose, lst
	vow = 0

	for c in choose:
		for v in vows:
			if c == v:
				vow += 1
	con = R - vow
	return (vow >= 1 and con >= 2)

def comb(index, level):
	global N, R, choose
	if level == R:
		if if_possible():
			for u in choose:
				print(u, end='')
			print()

	for i in range(index, N):
		choose.append(lst[i])
		comb(i + 1, level+1)
		choose.pop()

vows = ['a', 'e', 'i', 'o', 'u']
R, N, = map(int, input().split())
lst = sorted(list(input().split()))

choose = []

comb(0,0)