package org.conoha.sample;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TargetProtectedClassTestCase {

	private TargetProtectedClass _targetInstance;
	private Class<TargetProtectedClass> _targetClass;

	@SuppressWarnings("unchecked")
	@Before
	public void setUp() throws Exception {
		_targetInstance = new TargetProtectedClass();
		_targetClass = (Class<TargetProtectedClass>) _targetInstance.getClass();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testExecute() {
		try {
			// メソッド取得
			Method method = _targetClass.getDeclaredMethod("execute");
			// メソッド実行
			String result = (String) method.invoke(_targetInstance);
			assertEquals(result, "OK!");
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
