

	



	//From the Player class

	public void shoot()						// I modified the shoot()
	{
		hasBullet = false;
	}

	
	//From the Engine

	public boolean checkBullet() {							//check the bullet before shoot in the UI
		if(grid.getPlayer().hasBullet())
			return true;
		return false;
	}
	
	/**
	 * The hub shoot method, a method that accepts a String value as a parameter. Depending on the value of this
	 * String, the player will be allowed to shoot in a certain direction. The corresponding direction calls a
	 * specific method due to unique shooting rules.
	 */
	public boolean shoot(String input)
	{
		grid.getPlayer().shoot();
		
		if(input=="w" || input=="W")
			return shootUp();
		
		else if(input=="s" || input=="S")
			return shootDown();
		
		else if(input=="d" || input=="D")
			return shootRight();
		
		else
			return shootLeft();
	}
	
	/**
	 * A method that determines if a player is able to shoot upwards, according to specific shooting rules.
	 */
	public boolean shootUp()
	{	
		int row = grid.getPlayer().getRow() -1;						//start from the above square of the spy
		int col = grid.getPlayer().getColumn();
				
		while(row >= 0) {
			
			if(grid.getGridObject(row,col).isARoom())				//block by the room
				return false;
			
			if(grid.getGridObject(row,col).isAnEnemy()) {			//kill the first enemy in the line
				enemyIsKilled(row, col);
				return true;
			}
			
			row--;
		}
		
		return false;
		
		// For the false, display "Nothing happened" in the UI
		// For the true, display "enemy is killed"
	}

	/**
	 * A method that determines if a player is able to shoot downwards, according to specific shooting rules.
	 */
	public boolean shootDown()
	{
		int row = grid.getPlayer().getRow() +1;						//start from the bottom square of the spy
		int col = grid.getPlayer().getColumn();
				
		while(row <= 8) {
			
			if(grid.getGridObject(row,col).isARoom())				//block by the room
				return false;
			
			if(grid.getGridObject(row,col).isAnEnemy()) {			//kill the first enemy in the line
				enemyIsKilled(row, col);
				return true;
			}
			
			row++;
		}
		
		return false;
	}
	
	
	/**
	 * A method that determines if a player is able to shoot rightwards, according to specific shooting rules.
	 */
	public boolean shootRight()
	{
		int row = grid.getPlayer().getRow();						
		int col = grid.getPlayer().getColumn() +1;					//start from the right square of the spy
				
		while(col <= 8) {
			
			if(grid.getGridObject(row,col).isARoom())				//block by the room
				return false;
			
			if(grid.getGridObject(row,col).isAnEnemy()) {			//kill the first enemy in the line
				enemyIsKilled(row, col);
				return true;
			}
			
			col++;
		}
		
		return false;
	}
	
	
	/**
	 * A method that determines if a player is able to shoot leftwards, according to specific shooting rules.
	 */
	public boolean shootLeft()
	{	
		int row = grid.getPlayer().getRow();						
		int col = grid.getPlayer().getColumn() -1;					//start from the left square of the spy
				
		while(col >= 0) {
			
			if(grid.getGridObject(row,col).isARoom())				//block by the room
				return false;
			
			if(grid.getGridObject(row,col).isAnEnemy()) {			//kill the first enemy in the line
				enemyIsKilled(row, col);
				return true;
			}
			
			col--;
		}
		
		return false;
	}
	
	private void enemyIsKilled(int row, int col)								// modified by Dongri
	{
		//here needs a duplicate case, which the enemy duplicates with other items
		grid.removeGridObject(row, col);
	}

