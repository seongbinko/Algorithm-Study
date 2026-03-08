arr = ['' for i in range(13) ]
arr[0] = '-'

for i in range(1,13):
	arr[i] = arr[i-1] + ' ' * (3**(i-1)) + arr[i-1]



def 칸토어_집합(i):
	# base case
	if arr[i] != '':
		return arr[i]
	arr[i] = 칸토어_집합(i-1) + ' ' * (3**(i-1)) + 칸토어_집합(i-1)
	return arr[i]


while True:
	try:
		N = int(input())
		print(arr[N])
		print(칸토어_집합(N))
	except:
		break
	