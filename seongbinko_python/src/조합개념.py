
N = 10
R = 5
lst = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
choose = [] # 선택한 원소를 보관

def comb(index, level):
	if level == R:
		# 선택한 R개의 원소를 선택
		print(choose)
		return
	for i in range(index, 10):
		choose.append(lst[i])
		comb(i + 1, level + 1)
		choose.pop()


comb(0,0)