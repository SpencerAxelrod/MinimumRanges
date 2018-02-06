def find_min_ranges(ranges):
	"""
	Produces the minimum number of ranges required to represent the input list of ranges
	
	Args:    
		ranges: A list of ranges. A range is represented as a list with two items, an upper bound and lower bound
		
	Returns:    
		A list of the minimum ranges required.
	"""
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
		# If the current range cannot be merged, it is part of the final min_range list
		if not merged:
			min_ranges.append(current)
		merged = False
	return min_ranges