import java.util.*;

public class classicaco
    {
    static public int Ants = 75; // count of ants;
    static public int Iterations = 3221;
    static public int MaxLength = 20;// max length of path
	static public int Degree = 200;// degree of Rudy's graph
    static public int Verticles = 8 * Degree + 5;
    static public double Alpha = 2.1; // wykladnik
    static public double Beta = 5.5; // wykladnik
    static public double Ro = 0.32; // p in (1-p)*pheromone
    static public double Q = 3.14; // adding pheromone
    static public double Bonus = 5; // prize for finding better way
    static public ArrayList<ArrayList<Path>> graph;
	public static void main(String[] args)
        {
			graph = GenerateGraph(Degree, Verticles);
            List<Ant> ants = new ArrayList<Ant>();
            ArrayList<Ant> finished = new ArrayList<Ant>();
            List<Path> bbb = new ArrayList<Path>();
            ArrayList<Integer> results = new ArrayList<Integer>();
			results.add(MaxLength * Verticles);
            int mininum = results.get(0);
			Random r = new Random(105);
            for (int j = 0; j < Ants; j++) ants.add(new Ant(0, Verticles));
            double n = 0.0;
            for (int i = 0; i < Iterations; ++i) 
            {
				for(Ant ant:ants)
				{
					if(ant.position == Verticles) 
					{
						double delta = Q / ant.lengthOfWay;
						results.add(ant.lengthOfWay);
						System.out.println(ant.lengthOfWay);
						if (mininum > ant.lengthOfWay)
						{
							for(Path path : ant.way) path.pheromone += Bonus*delta;
							mininum =  ant.lengthOfWay;
						}
						else for(Path path : ant.way) path.pheromone += delta;
						
						for(ArrayList<Path> list : graph)
						{
							for(Path path : list)
							{
								path.pheromone *= (1-Ro);
							}
						}
						ant.Clear();
					}
					n = 0.0;
					for(Path path : graph.get(ant.position))
					{                 
						n += path.GetMultiplier();
					}
					for(Path path : graph.get(ant.position))
					{	
						if (r.nextDouble() > path.GetMultiplier() / n) continue;
						ant.Move(path);
						ant.visits++;
						break;
						
					}  
                }
            }
			System.out.print("best:");
			System.out.println(CalcShortPath(0, Verticles));
			System.out.print("our best:");
			System.out.println(mininum);
        }
		static int CalcShortPath(int from, int to)
			{
				int[] dist = new int[graph.size()];
				for(int i=0;i<dist.length;++i) dist[i] = Integer.MAX_VALUE;
				Queue<Integer> q = new LinkedList<Integer>();
				dist[from]=0;
				q.add(from);
				while(!q.isEmpty())
				{
					int top = q.remove();
					for(int index = 0; index < graph.get(top).size(); index++)
					{
						Path p = graph.get(top).get(index);
						if(dist[p.to] > dist[p.from] + p.Length)
						{
							dist[p.to] = dist[p.from] + p.Length;
							q.add(p.to);
						}
					}
				}
			return dist[to];
			}
	static public ArrayList<ArrayList<Path>> GenerateGraph(int degree, int verticles)
        {
            Random r = new Random();
            ArrayList<ArrayList<Path>> res = new ArrayList<ArrayList<Path>>();
            ArrayList<Path> verticle = new ArrayList<Path>();
            for(int i=1;i<=4;++i)   
				{
				verticle.add(new Path(0, i, r.nextInt(MaxLength)+1, 1.0/verticles));
				}
            res.add(verticle);                                                              
            for (int i=0;i<degree;++i)                                                      
            {                                                                               
                for (int j = 0; j < 8; j++) res.add(new ArrayList<Path>());                      
                res.get(8 * i + 2).add(new Path(8 * i + 2, 8 * i + 1 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 3).add(new Path(8 * i + 3, 8 * i + 2 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 4).add(new Path(8 * i + 4, 8 * i + 3 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 5).add(new Path(8 * i + 5, 8 * i + 6 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 6).add(new Path(8 * i + 6, 8 * i + 7 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 7).add(new Path(8 * i + 7, 8 * i + 8 , r.nextInt(MaxLength)+1, 1.0/verticles));// pion
                res.get(8 * i + 5).add(new Path(8 * i + 5, 8 * i + 9 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 6).add(new Path(8 * i + 6, 8 * i + 10, r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 7).add(new Path(8 * i + 7, 8 * i + 11, r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 8).add(new Path(8 * i + 8, 8 * i + 12, r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 1).add(new Path(8 * i + 1, 8 * i + 5 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 2).add(new Path(8 * i + 2, 8 * i + 6 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 3).add(new Path(8 * i + 3, 8 * i + 7 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 4).add(new Path(8 * i + 4, 8 * i + 8 , r.nextInt(MaxLength)+1, 1.0/verticles)); // poziom
                res.get(8 * i + 2).add(new Path(8 * i + 2, 8 * i + 5 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 3).add(new Path(8 * i + 3, 8 * i + 6 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 4).add(new Path(8 * i + 4, 8 * i + 7 , r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 5).add(new Path(8 * i + 5, 8 * i + 10, r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 6).add(new Path(8 * i + 6, 8 * i + 11, r.nextInt(MaxLength)+1, 1.0/verticles));
                res.get(8 * i + 7).add(new Path(8 * i + 7, 8 * i + 12, r.nextInt(MaxLength)+1, 1.0/verticles));   
            }                                                                              
            for (int i = 1; i <= 4; ++i) res.add(new ArrayList<Path>());
			for (int i = 1; i <= 4; ++i) res.get(8*degree+i).add( 
					new Path(8 * degree + i, 8 * degree + 5, r.nextInt(MaxLength)+1, 1.0/verticles));
            
			res.add(new ArrayList<Path>()); // empty list for last verticle
            return res;
		}
	}