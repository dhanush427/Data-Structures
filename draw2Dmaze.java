g2.setColor(Color.GREY);

for(int c = 0; c<maze[0].length ; c++) {
	for(int r = 0; r<maze[0].length ; r++) {
		if(maze[r][c] == ' ')
			g2.fillRectc(c*size*size, r*size*size,size,size);
		else
			g2.drawRect(c*size*size, r*size*size,size,size);
	}
}

g2.setColor(hero.getcolor());
g2.fill(hero.getRect());