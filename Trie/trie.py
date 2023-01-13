class Node:
	def __init__(self, character: str, prefix: str, complete: bool, ranking: int):
		self.ch = character
		self.is_complete_word = complete
		self.children = dict()	# {"a" : Node}

class Trie:
	def __init__(self):
		self.sentinel = Node('-', '-', False, 0)
		self.size = 0

	def insert(self, word: str, ranking=1) -> None:
		node_pointer = self.sentinel
		prefix = ""
		for character in word:
			prefix += character
			child = node_pointer.children.get(character)
			if child == None:
				new_child = Node(character, prefix, False, ranking)
				node_pointer.children[character] = new_child
				node_pointer = new_child
				self.size += 1
			else:
				node_pointer = child
		node_pointer.is_complete_word = True
		node_pointer.ranking = ranking

	def contains_word(self, word: str) -> bool:
		node_pointer = self.sentinel
		for character in word:
			child = node_pointer.children.get(character)
			if child == None:
				return False
			node_pointer = child
		return node_pointer.is_complete_word









