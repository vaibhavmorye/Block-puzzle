package com.block;

import java.util.HashSet;
import java.util.Scanner;

public class BlockGame {

	public static void main(String[] args) {

		HashSet<Block> blocks = new HashSet<Block>();
		// Scanner sc = new Scanner(System.in);
		// Boolean takeIn = true;

		Block mainBlock = new Block(2, 2, 8);

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

		Block srcBlock = new Block(6, 4, 2);
		//
		// Block mainBlock = new Block();
		//
		// System.out.println("Please enter starting coordinate of main squre");
		// System.out.println("Please Enter X cordinate");
		// mainBlock.x = sc.nextInt();
		// System.out.println("Please Enter Y cordinate");
		// mainBlock.y = sc.nextInt();
		// System.out.println("Please Enter D size of squre");
		// mainBlock.d = sc.nextInt();
		//
		// while (takeIn) {
		// Block block = new Block();
		//
		// System.out.println("please enter internal square coordinate only");
		// System.out.println("Please Enter X coordinate");
		// block.x = sc.nextInt();
		// System.out.println("Please Enter Y coordinate");
		// block.y = sc.nextInt();
		// System.out.println("Please Enter D size of square");
		// block.d = sc.nextInt();
		// System.out.println("If you wish to stop : enter 1 to keep going or 0 to
		// stop");
		// int startStop = sc.nextInt();
		// takeIn = (startStop == 1?true:false);
		// blocks.add(block);
		// }
		//
		// Block srcBlock = new Block();
		// System.out.println("please enter cordinates of block");
		// System.out.println("Please Enter X cordinate");
		// srcBlock.x = sc.nextInt();
		// System.out.println("Please Enter Y cordinate");
		// srcBlock.y = sc.nextInt();
		// System.out.println("Please Enter D size of squre");
		// srcBlock.d = sc.nextInt();
		// sc.close();
		Block ans = findWBlockX(srcBlock, srcBlock, mainBlock, blocks);
		if (ans == null) {
			System.out.println("There no neighour to this block");
		} else {
			System.out.println(ans.toString());
		}

	}

	public static Block findWBlockX(Block srcBlock, Block search, Block mainBlock, HashSet<Block> blocks) {

		int x = srcBlock.x;
		int y = srcBlock.y;
		int d = srcBlock.d;

		// System.out.println("srcBlock"+srcBlock.toString());

		Block toFind = new Block();
		toFind.x = x - d;
		toFind.y = y;
		toFind.d = d;
		try {
			if (toFind.x >= mainBlock.x) {
				if (blocks.contains(toFind)) {
					for (Block b : blocks) {
						if (b.equals(toFind))
							return b;
					}
				} else {
					if (toFind.x == mainBlock.x) {
						return findWBlockY(search, search, mainBlock, blocks, false);
					} else {
						toFind.x = x;
						toFind.y = y;
						toFind.d = d * 2;
						return findWBlockX(toFind, search, mainBlock, blocks);
					}
				}
			}
		} catch (Exception e) {
			System.out.println("There no neighour to this block");
		}

		return null;
	}

	private static Block findWBlockY(Block srcBlock, Block search, Block mainBlock, HashSet<Block> blocks,
			Boolean jump) {

		// System.out.println("search"+search.toString());
		// System.out.println("1 srcBlock" + srcBlock.toString());

		// return search;

		int x = srcBlock.x;
		int y = srcBlock.y;
		// int d = srcBlock.d;

		Block toFind = new Block();
		if (jump) {
			toFind.x = x - srcBlock.d;
			toFind.y = y - srcBlock.d;
			toFind.d = srcBlock.d;
		} else {
			toFind.x = x - srcBlock.d;
			toFind.y = srcBlock.y;
			toFind.d = srcBlock.d;
		}

		System.out.println("2 toFind.toString" + toFind.toString());

		if (toFind.x >= mainBlock.x) {
			// System.out.println(" 3 I am here" + toFind.toString());
			if (blocks.contains(toFind)) {
				// System.out.println("4 I am here too" + toFind.toString());
				for (Block b : blocks) {
					if (b.equals(toFind))
						return b;
				}
			} else {
				if (toFind.y == mainBlock.y) {
					return null;
				} else {
					jump = !jump;
					return findWBlockY(toFind, search, mainBlock, blocks, jump);
				}
			}
		}

		return null;
	}

}
