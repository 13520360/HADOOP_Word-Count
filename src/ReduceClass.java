import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ReduceClass 
		extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	@Override
	protected void reduce(Text key, Iterable<IntWritable> values,
			Context context)
			throws IOException, InterruptedException {
	
		int sum = 0;
		Iterator<IntWritable> valuesIt = values.iterator();
		
        //For each key value pair, get the value and adds to the sum
        //to get the total occurances of a word
		while(valuesIt.hasNext()){
			sum = sum + valuesIt.next().get();
		}
		
        //Writes the word and total occurances as key-value pair to the context
		context.write(key, new IntWritable(sum));
	}		
}
