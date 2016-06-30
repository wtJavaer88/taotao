import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
	public static void main(String[] args) {
		testStrip();
		testJoinSplit();
		testAbbreviate();
		testOthers();
		testRemoveAndReplace();
		testreplaceEach();
	}

	private static void testreplaceEach() {
		System.out.println("### testreplaceEach");
		String str = "abcdade";
		String[] searchArr = new String[] { "ab", "a" };
		String[] replaceArr = new String[] { "d", "t" };
		String result = "";
		while (str.length() > 0) {
			int findIndex = getMatchedIndex(str, searchArr);
			if (findIndex != -1) {
				result += replaceArr[findIndex];
				str = str.substring(searchArr[findIndex].length());
			} else {
				result += str.charAt(0);
				if (str.length() == 1) {
					break;
				}
				str = str.substring(1);
			}
		}
		System.out.println("result:" + result);
	}

	private static int getMatchedIndex(String str, String[] searchArr) {
		for (int i = 0; i < searchArr.length; i++) {
			if (str.startsWith(searchArr[i])) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * <pre>
	 * Remove移除, 只移除一次
	 * replace替换, 可以指定次数
	 * replaceChars, 根据指定的参数来一对一替换,如果searchChars长度长于replaceChars,则用空字符来替换
	 * replaceEach 不是连续替换, 而是逐一找到合适的然后替换,最后把替换的结果拼起来
	 * replaceEachRepeatedly 跟上面不同,相当于连环替换
	 * StringUtils.replaceChars("abcbeacccccd", "abcdefg", "xy") = xyyx
	 * removePattern可以移除n个 相当于replaceAll
	 * replace的第四个参数,如果是负数, 则不限次数会替换所有的
	 * </pre>
	 */
	private static void testRemoveAndReplace() {
		System.out.println("### testRemoveAndReplace");
		System.out.println(StringUtils.removeEnd("AABBCCAAAAA", "AA"));
		System.out.println(StringUtils.removePattern("AA5BBCCAAAAA18", "AA\\d+"));
		System.out.println(StringUtils.removeEndIgnoreCase("AABBCCAAAaA", "Aa"));
		System.out.println(StringUtils.removeStart("AA5BBCCAAAAA18", "AA"));
		System.out.println(StringUtils.removeStartIgnoreCase("AA5BBCCAAAAA18", "aa"));
		System.out.println(StringUtils.replace("AA5BBCCAAAAA18", "AA", "SS", 2));
		System.out.println(StringUtils.replace("AA5BBCCAAAAA18", "AA", "SS", -1));
		System.out.println(StringUtils.replace("AA5BBCCAAAAA18", "AA", "SS", -1));
		System.out.println(StringUtils.replaceChars("abcba", "bc", "yz"));
		System.out.println(StringUtils.replaceChars("abcba", "bc", "yzx"));
		System.out.println(StringUtils.replaceChars("abcba", "ba", "y"));
		System.out.println(StringUtils.replaceChars("abcbeacccccd", "abcdefg", "xy"));
		System.out.println(StringUtils.replace("abcbeacccccd", "abcdefg", "xy"));
		System.out.println(StringUtils.replaceEach("abcde", new String[] { "ab", "d" }, new String[] { "d", "ab" }));
		System.out.println(StringUtils.replaceEach("abcdade", new String[] { "ab", "a" }, new String[] { "d", "t" }));
		// 只替换第一个
		System.out.println(StringUtils.replaceOnce("abcadea", "a", "x"));
		System.out.println(
				StringUtils.replaceEachRepeatedly("abcde", new String[] { "ab", "d" }, new String[] { "d", "t" }));
		// 下面会报循环的错误--理由查看源代码, 解决:在每个数组后同时添加一个元素,如空字符串""
		try {
			System.out.println(StringUtils.replaceEachRepeatedly("aaa", new String[] { "aa" }, new String[] { "aXa" }));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试strip函数 *
	 * 
	 * <pre>
	 * 
	 * StringUtils.stripStart(null, *)          = null
	 * StringUtils.stripStart("", *)            = ""
	 * StringUtils.stripStart("abc", "")        = "abc"
	 * StringUtils.stripStart(" abc ", "")        = " abc "
	 * StringUtils.stripStart("abc", null)      = "abc"
	 * StringUtils.stripStart("  abc", null)    = "abc"
	 * StringUtils.stripStart("abc  ", null)    = "abc  "
	 * StringUtils.stripStart(" abc ", null)    = "abc "
	 * StringUtils.stripStart("yxabc  ", "xyz") = "abc  "
	 * StringUtils.stripStart(" yxabc  ", "xyz") = "abc  "
	 * </pre>
	 */
	private static void testStrip() {
		System.out.println("### testStrip");
		// 第二个参数为null时,去掉开头的空字符再返回
		// 第二个参数为""时,原样返回
		// 第二个参数为其它情况时,从第一个参数的开头找出第二个字符串中的字符逐一删除直到找不到为止
		// 对于第一个参数前面有空格,而第二个参数又不为空的,就不起作用了
		System.out.println(StringUtils.stripStart(" yxabc  ", "xyz") + "$"); // 返回原样
		System.out.println(StringUtils.strip(" yxabc  ", "") + "$");// 返回原样
	}

	/**
	 * 测试strip函数 *
	 * 
	 * <pre>
	 * 
	 * StringUtils.join(Arrays.asList("AA", null, "CC", "DD"), "&")          = AA&&CC&DD
	 * StringUtils.join(Arrays.asList("AA", "", "CC", "DD"), "&")          = AA&&CC&DD
	 * StringUtils.join(Arrays.asList("AA", "BB", "CC", "DD"), "&")          = AA&BB&CC&DD
	 * StringUtils.split("AA&&CC&DD", '&')        = [AA, CC, DD]
	 * StringUtils.split("AA& &CC&&", '&')      = [AA,  , CC]
	 * </pre>
	 */
	private static void testJoinSplit() {
		System.out.println("### testJoinSplit");
		System.out.println(StringUtils.join(Arrays.asList("AA", null, "CC", "DD"), "&"));
		System.out.println(StringUtils.join(new String[] { "AA", "BB", "CC", "DD" }, "&"));
		System.out.println(Arrays.toString(StringUtils.split("AA&&CC&DD", '&')));
		System.out.println(Arrays.toString(StringUtils.split("AA& &CC&&", '&')));
	}

	/**
	 * <pre>
	 * 字符串缩写 
	 * abbreviate省略后边的 
	 * abbreviateMiddle省略中间的
	 * </pre>
	 */
	private static void testAbbreviate() {
		System.out.println("### testAbbreviate");
		// System.out.println(StringUtils.abbreviate("org.apache.commons.lang.StringUtils",
		// 5, 10));
		System.out.println(StringUtils.abbreviate("org.apache.commons.lang.StringUtils", 10));
		System.out.println(StringUtils.abbreviateMiddle("org.apache.commons.lang.StringUtils", "……省略……", 11));
	}

	/**
	 * <pre>
	 * repeat函数  参数2表示字符串中间的连接字符
	 * StringUtils.repeat("ABCDE", ",", 5) = ABCDE,ABCDE,ABCDE,ABCDE,ABCDE
	 * startsWithAny函数  n个字符串参数,首字符串是否以后面的某个字符串开头
	 * </pre>
	 */
	private static void testOthers() {
		System.out.println("### testOthers");
		System.out.println(StringUtils.repeat("ABCDE", ",", 5));
		System.out.println(StringUtils.startsWithAny("ABCCDD", "CD", "ABCC"));
	}

}
