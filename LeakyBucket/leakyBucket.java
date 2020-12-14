import java.io.*;
import java.util.*;

class leakyBucket{
	public static void main(String [] args){
	int no_of_queries, storage, output_pkt_size;
	int input_pkt_size, bucket_size, size_left;
	
	Scanner sc=new Scanner(System.in);
	storage=0;
	System.out.println("Enter number of queries");
	no_of_queries = sc.nextInt();
	System.out.println("Enter Bucket size");
	bucket_size = sc.nextInt();
	System.out.println("Enter output packet size");
	output_pkt_size = sc.nextInt();
	
	int pkt[] = new int[no_of_queries];
	for(int i=0; i<no_of_queries; i++)
	{
		System.out.println("Enter input packet size");
		input_pkt_size = sc.nextInt();
		pkt[i] = input_pkt_size;
	}
	
	for(int i=0; i<no_of_queries; i++)
	{
		size_left = bucket_size - storage;
		if(pkt[i] >= 10)
		{
			System.out.println("Bucket Overflow");
		}
		else if(pkt[i] <= (size_left))
		{
			storage += pkt[i];
			System.out.println("Buffer Size= "+storage+" out of 			bucket size= "+bucket_size);
		}
		else
		{
			System.out.println("Packet Loss= "+(pkt[i] - 								(size_left)));
			storage = bucket_size;
			System.out.println("Buffer Size= "+storage+" out of 						bucket size= "+bucket_size);
		}
		storage -= output_pkt_size;
	}
}
}
	