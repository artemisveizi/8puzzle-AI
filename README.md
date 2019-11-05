# 8puzzle-AI
Java and Python solutions provided in repo.

Optimized 8 puzzle solver. Queues possible "moves" (0 moves up, down, left, right), excluding those configurations already "visited" (added to the queue), and continually traverses in search of a solved child board.

Solves 8 puzzle with BFS using collections.deque (supports efficient push/pop operations) as the fringe (queue of possible moves), optimized to search children at lower depths first (basic optimization to find shortest path to solution). 

*Example run:*

(Initial board)
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td>8</td>
    <td>4</td>
    <td><b>0</b></td>
  </tr>
  <tr>
    <td>2</td>
    <td>5</td>
    <td>7</td>
  </tr>  
</table>

D
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td>8</td>
    <td>4</td>
    <td>7</td>
  </tr>
  <tr>
    <td>2</td>
    <td>5</td>
    <td><b>0</b></td>
  </tr>  
</table>

L
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td>8</td>
    <td>4</td>
    <td>7</td>
  </tr>
  <tr>
    <td>2</td>
    <td><b>0</b></td>
    <td>5</td>
  </tr>  
</table>

U
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td>8</td>
    <td><b>0</b></td>
    <td>7</td>
  </tr>
  <tr>
    <td>2</td>
    <td>4</td>
    <td>5</td>
  </tr>  
</table>

L
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td><b>0</b></td>
    <td>8</td>
    <td>7</td>
  </tr>
  <tr>
    <td>2</td>
    <td>4</td>
    <td>5</td>
  </tr>  
</table>

D
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td>2</td>
    <td>8</td>
    <td>7</td>
  </tr>
  <tr>
    <td><b>0</b></td>
    <td>4</td>
    <td>5</td>
  </tr>  
</table>

R
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td>2</td>
    <td>8</td>
    <td>7</td>
  </tr>
  <tr>
    <td>4</td>
    <td><b>0</b></td>
    <td>5</td>
  </tr>  
</table>

U
<table>
  <tr>
    <td>3</td>
    <td>1</td>
    <td>6</td>
  </tr>
  <tr>
    <td>2</td>
    <td><b>0</b></td>
    <td>7</td>
  </tr>
  <tr>
    <td>4</td>
    <td>8</td>
    <td>5</td>
  </tr>  
</table>

U
<table>
  <tr>
    <td>3</td>
    <td><b>0</b></td>
    <td>6</td>
  </tr>
  <tr>
    <td>2</td>
    <td>1</td>
    <td>7</td>
  </tr>
  <tr>
    <td>4</td>
    <td>8</td>
    <td>5</td>
  </tr>  
</table>

L
<table>
  <tr>
    <td><b>0</b></td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td>2</td>
    <td>1</td>
    <td>7</td>
  </tr>
  <tr>
    <td>4</td>
    <td>8</td>
    <td>5</td>
  </tr>  
</table>

D 
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td><b>0</b></td>
    <td>1</td>
    <td>7</td>
  </tr>
  <tr>
    <td>4</td>
    <td>8</td>
    <td>5</td>
  </tr>  
</table>

R
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td>1</td>
    <td><b>0</b></td>
    <td>7</td>
  </tr>
  <tr>
    <td>4</td>
    <td>8</td>
    <td>5</td>
  </tr>  
</table>

R
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td>1</td>
    <td>7</td>
    <td><b>0</b></td>
  </tr>
  <tr>
    <td>4</td>
    <td>8</td>
    <td>5</td>
  </tr>  
</table>

D
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td>1</td>
    <td>7</td>
    <td>5</td>
  </tr>
  <tr>
    <td>4</td>
    <td>8</td>
    <td><b>0</b></td>
  </tr>  
</table>

L
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td>1</td>
    <td>7</td>
    <td>5</td>
  </tr>
  <tr>
    <td>4</td>
    <td><b>0</b></td>
    <td>8</td>
  </tr>  
</table>

U
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td>1</td>
    <td><b>0</b></td>
    <td>5</td>
  </tr>
  <tr>
    <td>4</td>
    <td>7</td>
    <td>8</td>
  </tr>  
</table>

R
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td>6</td>
  </tr>
  <tr>
    <td>1</td>
    <td>5</td>
    <td><b>0</b></td>
  </tr>
  <tr>
    <td>4</td>
    <td>7</td>
    <td>8</td>
  </tr>  
</table>

U
<table>
  <tr>
    <td>2</td>
    <td>3</td>
    <td><b>0</b></td>
  </tr>
  <tr>
    <td>1</td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td>4</td>
    <td>7</td>
    <td>8</td>
  </tr>  
</table>

L
<table>
  <tr>
    <td>2</td>
    <td><b>0</b></td>
    <td>3</td>
  </tr>
  <tr>
    <td>1</td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td>4</td>
    <td>7</td>
    <td>8</td>
  </tr>  
</table>

L
<table>
  <tr>
    <td><b>0</b></td>
    <td>2</td>
    <td>3</td>
  </tr>
  <tr>
    <td>1</td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td>4</td>
    <td>7</td>
    <td>8</td>
  </tr>  
</table>

D
<table>
  <tr>
    <td>1</td>
    <td>2</td>
    <td>3</td>
  </tr>
  <tr>
    <td><b>0</b></td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td>4</td>
    <td>7</td>
    <td>8</td>
  </tr>  
</table>

D
<table>
  <tr>
    <td>1</td>
    <td>2</td>
    <td>3</td>
  </tr>
  <tr>
    <td>4</td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td><b>0</b></td>
    <td>7</td>
    <td>8</td>
  </tr>  
</table>

R
<table>
  <tr>
    <td>1</td>
    <td>2</td>
    <td>3</td>
  </tr>
  <tr>
    <td>4</td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td>7</td>
    <td><b>0</b></td>
    <td>8</td>
  </tr>  
</table>

R (Solved board)
<table>
  <tr>
    <td>1</td>
    <td>2</td>
    <td>3</td>
  </tr>
  <tr>
    <td>4</td>
    <td>5</td>
    <td>6</td>
  </tr>
  <tr>
    <td>7</td>
    <td>8</td>
    <td><b>0</b></td>
  </tr>  
</table>
