# Simple bloom filter algorithm 

from bitarray import bitarray
import math
#import pyhash

# Initialize bloom bitarray
bloom_arr = bitarray()					
bloom_arr_length = 100
for i in range(0, bloom_arr_length):
	bloom_arr.append(0)

# Test array of names
test_arr = ["Creg", "Simzy", "Dean", "Joan", "Zalniun", "Kerry", \
	"Westley", "Rob", "Tylan", "Damien", "Kiptee", "Sploodoo"]					

# Names will be appended here, if successfully verified that they
# don't already exist in the bloom_arr
val_arr = []


#-------------------- The Bloom --------------------#

def check_and_add(val):
	"""Checks if value is in the bloom_arr. If not, it adds the value. 
	If the value is in bloom_arr, it returns a message. """
	hashed_index1 = hash1(val)
	hashed_index2 = hash2(val, hashed_index1)

	if check_helper(hashed_index1, hashed_index2):
		print("Value '" + val + "' already exists in bloom array. Try again!")
		return

	add_helper(val, hashed_index1, hashed_index2)
		


#----------------- Helper Functions -----------------#

def hash1(val):
	"""Maps val to 'hashed' index"""
	hashed_index1 = hash(val) % bloom_arr_length
	return hashed_index1

def hash2(val, hashed_index1):
	"""Maps val to 'hashed' index"""
	hashed_index2 = hash(val) * hashed_index1 % bloom_arr_length
	return hashed_index2

def check_helper(hashed_index1, hashed_index2):
	"""Returns True if the val is in bloom_arr, 
	returns False if not. """
	if bloom_arr[hashed_index1] == 0 or bloom_arr[hashed_index2] == 0:
		return False
	return True

def add_helper(val, hashed_index1, hashed_index2):
	"""Adds element to bloom_arr"""
	bloom_arr[hashed_index1] = 1
	bloom_arr[hashed_index2] = 1
	val_arr.append(val)



#---------- BONUS! Accuracy Assessment -----------#



# Unfinished functions.

# Given a certain value and the pre-existing bloom array, what is the percent accuracy of the bloom filter??

def accuracy(val):
	"""Returns the percent accracy in bloom filter decision"""

	num_vals = len(val_arr)
	num_hash_funcs = 2

	

 

	if len(val_arr) < 2:
		return 1
	return val








