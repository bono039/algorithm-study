import sys
input = sys.stdin.readline

class Stack():
    def __init__(self):
        self.items = []

    # push X: 정수 X를 스택에 넣는 연산이다.
    def push(self, item):
        self.items.append(item)

    # pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    def pop(self):
        if len(self.items) == 0:
            return -1
        else:
            return self.items.pop()

    # size: 스택에 들어있는 정수의 개수를 출력한다.
    def size(self):
        return len(self.items)

    # empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    def is_empty(self):
        if len(self.items) == 0:
            return 1
        else:
            return 0

    # top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    def top(self):
        if len(self.items) == 0:
            return -1
        else:
            return self.items[-1]

    def __str__(self):
        return str(self.items)

if __name__ == "__main__":
    s = Stack()
    n = int(input())
    for _ in range(n):
        order = input().split()
        if order[0] == 'push':
            s.push(order[1])
        elif order[0] == 'pop':
            print(s.pop())
        elif order[0] == 'size':
            print(s.size())
        elif order[0] == 'empty':
            print(s.is_empty())
        else: # top
            print(s.top())
