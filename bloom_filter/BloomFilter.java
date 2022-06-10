/** 
 * Bloom filter interface.
 */

public interface BloomFilter {
	
	/** First hash of value. */
	public int hash(Object value);

	/** Second hash of value. */
	public int hash2(Object value);

	/** Returns true and adds value if value not present. Otherwise returns false. */ 
	public boolean addItem(Object value);

	/** Returns true if bloom filter contains value. Otherwise returns false. */
	public boolean contains(Object value);

}