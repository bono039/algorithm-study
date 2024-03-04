def next_word(word):
    n = len(word)
    i = n - 2
    while i >= 0 and word[i] >= word[i+1]: i -= 1
    if i == -1: return word
    j = n - 1
    while word[j] <= word[i]: j -= 1
    word_list = list(word)
    word_list[i], word_list[j] = word_list[j], word_list[i]
    word_list[i+1:] = reversed(word_list[i+1:])
    return ''.join(word_list)

for _ in range(int(input())):
    input_word = input()
    result = next_word(input_word)
    print(result)