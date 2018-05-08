# Block Puzzle code

scenario:
I have added some hardcoded input feel free to uncomment cli input section to test.

> scenario 
![alt text](https://github.com/vaibhavmorye/Block-puzzle/blob/master/src/photo_2018-05-08_15-36-04.jpg)


> Main Square
```
Block mainBlock = new Block(2, 2, 8);
```

> Internal squares
```
		blocks.add(new Block(6, 2, 4));
		blocks.add(new Block(2, 6, 4));
		blocks.add(new Block(6, 6, 2));
		blocks.add(new Block(8, 6, 2));
		blocks.add(new Block(6, 8, 2));
		blocks.add(new Block(8, 8, 2));

		blocks.add(new Block(8, 2, 2));
		blocks.add(new Block(8, 4, 2));
		blocks.add(new Block(6, 4, 2));
		blocks.add(new Block(4, 4, 2));
		blocks.add(new Block(2, 4, 2));
		blocks.add(new Block(4, 2, 2));
		blocks.add(new Block(2, 2, 2));
```

> Target Block
```
		Block srcBlock = new Block(6, 4, 2);
```