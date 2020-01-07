public class Assignment4 {
	
	public static int count=0;
	public static int[] cal_dist=new int[25];
	public static int[] dist=new int[25];
	public static int[] vertices=new int[25];
	public static int[] parent=new int[25];
	public static int graph_length;
	
	
	public static void main (String args[])
	{
		for(int i=0;i<25;i++)
		{
			cal_dist[i]=Integer.MAX_VALUE;
		}
		
		for(int j=0;j<25;j++)
		{
			dist[j]=Integer.MAX_VALUE;
		}
		
		int adjgraph[][] = new int [][] {
			{0,4,0,3,0,0,0,0,5,0,0},
			{4,0,0,0,0,0,0,5,0,0,8},
			{0,0,0,7,0,2,0,3,0,0,0},
			{3,0,7,0,2,0,0,0,0,0,0},
			{0,0,0,2,0,0,0,0,9,6,0},
			{0,0,2,0,0,0,9,0,0,8,0},
			{0,0,0,0,0,9,0,0,0,0,7},
			{0,5,3,0,0,0,0,0,0,0,6},
			{5,0,0,0,9,0,0,0,0,0,0},
			{0,0,0,0,6,8,0,0,0,0,0},
			{0,9,0,0,0,0,7,6,0,0,0}
					
		};			
			for (int i=0;i<adjgraph.length;i++)
			{
				for (int j=0;j<adjgraph[0].length;j++)
				{
					System.out.print(adjgraph[i][j]+" ");
				}
				System.out.println("\n");
			}
		
			graph_length=adjgraph.length;
			
			Assignment4 n = new Assignment4();
			n.Dijkstras(adjgraph,0,0);
			}
	
	
	void Dijkstras(int adjgraph[][], int row, int d)
	{
		int j=0;
		dist[j]=0;
		j++;
		for(int i = 1;i<adjgraph[0].length;i++)
		{			
			if(adjgraph[row][i]!=0)
			{
			dist[j]=adjgraph[row][i]+d;
				if(dist[j]==0)
				{
					dist[j]=Integer.MAX_VALUE;
							}
			}
				
				j++;
						
		}
		
		int p=0;
		for (int q=0;q<graph_length;q++)
		{
			if(dist[p]<cal_dist[q])
			{
			cal_dist[q]=dist[p];
			parent[q]=row;
			}
			p++;
		}
	
		Assignment4 a = new Assignment4();
		int[] indexlist=a.mindist(cal_dist,row);
		if(a.count!=graph_length-1)
		{
		a.Dijkstras(adjgraph,indexlist[0],indexlist[1]);
		}
		
	}
	
			int[] mindist(int cal_dist[], int row)
			{
			
				int[] indexlist = new int [2];
				int min=Integer.MAX_VALUE;
				int nextrow=1;
				
				for (int i = 1; i<graph_length;i++)
				{
					if (min>cal_dist[i]&&vertices[i]==0)
					{
						min=cal_dist[i];
						nextrow=i;
					
					}
				}
			
			vertices[nextrow]=min;
			
			System.out.println("Vertex	dist from source 	Parent");
			for(int y=0;y<graph_length;y++)
			{
			
			System.out.println(y+"	"+vertices[y]+"			"+parent[y]);
			}
			System.out.println("----------------------------------------------");
				
			indexlist[0]=nextrow;
			indexlist[1]=min;
			Assignment4 a = new Assignment4();
			a.count++;
			return indexlist;
			
			}
		}
	

