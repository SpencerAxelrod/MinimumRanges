# Takes a list of ranges. Ranges represented as a list with two items, an upper bound and lower bound
def find_min_ranges(ranges):
	min_ranges = []
	
	# Repeatedly pop the first range from the list and merge it with another list 
	# If it cannot be merged, add it to the final min_ranges list 
	while ranges:  
		merged = False  
		current = ranges.pop(0)
		
		# Attempt to find another range for current to merge with
		for range in ranges:
			
			# Case where current range lower bound is inside another
			if range[0] <= current[0] <= range[1]:
				range[1] = max(current[1],range[1])
				merged = True
				break
				
			# Case where current range upper bound is inside another
			if range[0] <= current[1] <= range[1]:
				range[0] = min(current[0], range[0])
				merged = True
				break
				
			# Case where current range contains another range
			if current[0] < range[0] and current[1] > range[1]:
				range[0], range[1] = current[0], current[1]
				merged = True
				break
				
		#if the current range cannot be merged, it is part of the final min_range list
		if not merged:
			min_ranges.append(current)
		merged = False
	return min_ranges
