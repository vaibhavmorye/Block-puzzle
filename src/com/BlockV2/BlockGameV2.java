package com.BlockV2;

import java.util.HashSet;

import com.block.Block;

public class BlockGameV2 {

	public static void main(String[] args) {
		HashSet<BlockV2> blockV2s = new HashSet<BlockV2>();
		BlockV2 mainBlockV2 = new BlockV2(2, 2, 8);

		//blockV2s.add(new BlockV2(2, 2, 2));
		// blockV2s.add(new BlockV2(4, 2, 2));
		blockV2s.add(new BlockV2(6, 2, 2));
		blockV2s.add(new BlockV2(8, 2, 2));
		blockV2s.add(new BlockV2(8, 2, 2));
		 blockV2s.add(new BlockV2(2, 4, 2));
		 blockV2s.add(new BlockV2(4, 4, 1));
		 blockV2s.add(new BlockV2(5, 4, 1));
		blockV2s.add(new BlockV2(6, 4, 2));
		 blockV2s.add(new BlockV2(4, 5, 1));
		 blockV2s.add(new BlockV2(5, 5, 1));
		blockV2s.add(new BlockV2(8, 4, 2));
		blockV2s.add(new BlockV2(2, 6, 4));
		blockV2s.add(new BlockV2(6, 6, 4));
		// blockV2s.add(new BlockV2(4, 4, 2));
		//blockV2s.add(new BlockV2(2, 2, 4));
		
		BlockV2 srcBlock = new BlockV2(4, 5, 1);

		BlockV2 ans = findWBlockX(srcBlock, srcBlock, mainBlockV2, blockV2s, true, false);

		if (ans == null) {
			System.out.println("There no neighour to this block");
		} else {
			System.out.println(ans.toString());
		}

	}

	private static BlockV2 findWBlockX(BlockV2 srcBlock, BlockV2 search, BlockV2 mainBlock, HashSet<BlockV2> blocks,
			Boolean jump, Boolean doubleJump) {

		double x = 0, y = 0, d = 0;
		if (doubleJump == true) {
			x = search.x;
			y = search.y;
			d = srcBlock.d;
		} else {
			x = search.x;
			y = search.y;
			d = srcBlock.d;
		}
		Boolean goin = false;
		BlockV2 toFind = new BlockV2();
		if (jump) {
			toFind.x = x - (d / 2);
			toFind.y = y;
			toFind.d = d / 2;
		} else {
			toFind.x = x - d;
			toFind.y = y;
			toFind.d = d;
		}

		if (jump == false && doubleJump == false)
			doubleJump = true;
		System.out.println("tofind" + toFind.toString());
		System.out.println("toFind.x:"+toFind.x+ "mainBlock.x:"+mainBlock.x);
		/*
		 * try { Thread.sleep(5000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		if (toFind.x >= mainBlock.x) {
			if (blocks.contains(toFind)) {
				for (BlockV2 b : blocks) {
					if (b.x == toFind.x && b.y == toFind.y) {
						if (b.d == toFind.d)
							return b;
						else
							goin = true;
					}
				}
			} else if (goin && toFind.x >= mainBlock.x) {
				toFind.x = x;
				toFind.y = y;
				return findWBlockX(toFind, search, mainBlock, blocks, true, false);
			} else if (doubleJump) {

				if (toFind.x == mainBlock.x && toFind.d > toFind.x) {
					return findWBlockY(search, search, mainBlock, blocks, false);
				}
				toFind.x = x;
				toFind.y = y;
				toFind.d = d * 2;
				//System.out.println("from here ");
				return findWBlockX(toFind, search, mainBlock, blocks, false, true);

			} else {
				return findWBlockX(search, search, mainBlock, blocks, false, false);
			}
		}
		return null;
	}

	private static BlockV2 findWBlockY(BlockV2 srcBlock, BlockV2 search, BlockV2 mainBlock, HashSet<BlockV2> blocks,
			Boolean jump) {

		// System.out.println("search"+search.toString());
		// System.out.println("1 srcBlock" + srcBlock.toString());

		// return search;

		double x = srcBlock.x;
		double y = srcBlock.y;
		// int d = srcBlock.d;

		BlockV2 toFind = new BlockV2();
		if (jump) {
			toFind.x = x - srcBlock.d;
			toFind.y = y - srcBlock.d;
			toFind.d = srcBlock.d;
		} else {
			toFind.x = x - srcBlock.d;
			toFind.y = srcBlock.y;
			toFind.d = srcBlock.d;
		}

		//System.out.println("2 toFind.toString" + toFind.toString());

		if (toFind.x >= mainBlock.x) {
			// System.out.println(" 3 I am here" + toFind.toString());
			if (blocks.contains(toFind)) {
				//System.out.println("4 I am here too" + toFind.toString());
				for (BlockV2 b : blocks) {
					if (b.x == toFind.x && b.y == toFind.y)
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
