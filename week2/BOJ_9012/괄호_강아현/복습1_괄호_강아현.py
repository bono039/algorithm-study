import sys

def is_right(brackets):
    stack = []
    for bracket in brackets:
        if bracket == "(":
            stack.append("(")
        else:
            if stack:
                stack.pop()
            else:
                return False
    return len(stack) == 0

for _ in range(int(sys.stdin.readline().rstrip())):
    brackets = sys.stdin.readline().rstrip()
    print("YES" if is_right(brackets) else "NO")