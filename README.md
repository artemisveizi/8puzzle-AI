# 8puzzle-AI
Optimized 8 puzzle solver.

*Example run:*
Initial board
  [3, 1, 6]
  [8, 4, 0]
  [2, 5, 7]

D
  [3, 1, 6]
  [8, 4, 7]
  [2, 5, 0]

L
  [3, 1, 6]
  [8, 4, 7]
  [2, 0, 5]

U
  [3, 1, 6]
  [8, 0, 7]
  [2, 4, 5]

L
  [3, 1, 6]
  [0, 8, 7]
  [2, 4, 5]

D
  [3, 1, 6]
  [2, 8, 7]
  [0, 4, 5]

R
  [3, 1, 6]
  [2, 8, 7]
  [4, 0, 5]

U
  [3, 1, 6]
  [2, 0, 7]
  [4, 8, 5]

U
  [3, 0, 6]
  [2, 1, 7]
  [4, 8, 5]

L
  [0, 3, 6]
  [2, 1, 7]
  [4, 8, 5]

D
  [2, 3, 6]
  [0, 1, 7]
  [4, 8, 5]

R
  [2, 3, 6]
  [1, 0, 7]
  [4, 8, 5]

R
  [2, 3, 6]
  [1, 7, 0]
  [4, 8, 5]

D
  [2, 3, 6]
  [1, 7, 5]
  [4, 8, 0]

L
  [2, 3, 6]
  [1, 7, 5]
  [4, 0, 8]

U
  [2, 3, 6]
  [1, 0, 5]
  [4, 7, 8]

R
  [2, 3, 6]
  [1, 5, 0]
  [4, 7, 8]

U
  [2, 3, 0]
  [1, 5, 6]
  [4, 7, 8]

L
  [2, 0, 3]
  [1, 5, 6]
  [4, 7, 8]

L
  [0, 2, 3]
  [1, 5, 6]
  [4, 7, 8]

D
  [1, 2, 3]
  [0, 5, 6]
  [4, 7, 8]

D
  [1, 2, 3]
  [4, 5, 6]
  [0, 7, 8]

R
  [1, 2, 3]
  [4, 5, 6]
  [7, 0, 8]

R (Solved board)
  [1, 2, 3]
  [4, 5, 6]
  [7, 8, 0]
