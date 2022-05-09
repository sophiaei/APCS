National Security Agency
APCS pd6
HW93 -- exploring tree properties, extracting actionable intel from traversals
2022-05-05r
time spent: 0.5 hrs


DISCO
------------------------------------------------
* Coming up with succint definitions is hard!!!
================================================


QCC
------------------------------------------------
* What does the last question refer to? Tree height? Human height?
================================================


SELF-ASSESSMENT PROMPTS
------------------------------------------------
In which direction does a tree grow?
Down

Provide as many alternate definitions as you can for "tree," using graph terminology ("closed/open tours", "paths", "cycles", etc). Maximize clarity, succinctness.
1. A tree is a graph in which there exists exactly one path between a given element and another given element
2. A tree is a set of paths through a given set of nodes with the restriction that certain nodes can only be reached from other specific nodes.

Why is a balanced tree allowed a difference of 1 in height between right and left subtrees?
Not entirely sure, but maybe it relates to the difference between complete and perfect trees. A complete tree is necessarily balanced, and if a tree is complete and b

Alternate (equivalent, but more succinct?) definitions of "balanced" tree?
Leaves of sister nodes can differ by at most 1 level

Is a perfect tree complete?
Yes. Trees with all levels complete are a subset of trees with all levels before the last level complete.

Is a complete tree balanced?
Yes. A complete tree has leaves only at its lowest and second-to-lowest levels, meaning its right and left subtrees only have leaves at their lowest and second-to-lowest levels. Thus, the difference in height between the right and left subtrees can be at most 1.

Is the Man Who Is Tall Happy?
Empirically speaking, yes: https://onlinelibrary.wiley.com/doi/10.1002/ajhb.23351
In terms of trees, it's not necessarily the case that the number of levels in a tree will have a direct effect on how easy or difficult to process, if that's what this question is referring to.

What must be true of perfect trees but not others?
The number of nodes on all levels must be a power of two (assuming these trees are binary)
================================================


C'EST POSSIBLE?
------------------------------------------------
We don't think the tree challenge given in class in possible, because we defined pre-order traversal to be traversal in which root is processed first, post-order traversal to process the root last, and in-order traversal to do neither. Thus, an in-order traversal and a pre-order traversal can't start with the same element.
================================================
