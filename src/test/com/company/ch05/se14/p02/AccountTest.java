package com.company.ch05.se14.p02;

import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * AAA (Triple-A)
 * Arrange (준비) - 시스템이 적절한 상태에 있는지 확인
 *               - 객채 생성, 객체와의 소통, API 호출
 * Act (실행) - 실제로 테스트 코드를 실행
 * Assert (단언) - 실행한 코드의 결과를 기대하는 값과 비교
 *
 * + @
 * After (사후) - 자원을 할당한 경우에는 이를 해제
 */
public class AccountTest {

    private  Account account;

    // 실행 순서 : Before -> Test1 -> Before -> Test2
    // BeforeClass -> Before -> Test1 -> (After) ->  Before -> Test2 -> (After) -> (AfterClass)

    @BeforeClass
    public static void classSetUp() {
        // 맨 처음 한 번만 실행
    }

    @Before // 매번 다시 실행
    public void setUpBySetBalanceOneHundred() {
         account = new Account(100); // 1. Arrange
    }

    @Test
    public void answerIsMinusWithNegativeBalance() {
//        Account account = new Account(100); // 1. Arrange
        account.withdraw(150); // 2. Act
        boolean actualResult = account.isMinus();

        //boolean에 대한 assertion은 assertTrue, assertFalse를 쓰면 좋다.
//        assertTrue(actualResult);
        assertThat(actualResult, equalTo(true)); // 3. Assert
//        assertThat(actualResult, is(true));
//        assertThat(actualResult, not(false));
//        assertThat(actualResult, is(equalTo(true)));
//        assertThat(actualResult, not(equalTo(false)));
        // 단, 실패했을 때 정보를 잘 표현하기 위해서는
        // hamcrest의 CoreMatchers에 구현된 matcher를 쓰는 것이 좋다
    }

    @Test
    public void answerIsMinusWithPositiveBalance() {
        account.withdraw(50);
        boolean actualResult = account.isMinus();

        assertThat(actualResult, is(not(equalTo(true))));
    }

    @Test
    public void checkPositiveBalanceAfterWithdrawal() {
        account.withdraw(80);
        int actualResult = account.getBalance();

        assertThat(actualResult, is(equalTo(20)));
    }

    @Test
    @Ignore("This will be tested later") // 나중에 테스트, 이것을 남겨두고 commit X
    public void checkNegativeBalanceAfterWithdrawal() {
        account.withdraw(120);
        int actualResult = account.getBalance();

        assertThat(actualResult, is(equalTo(-20)));
    }

    // ArithmeticException이 발생하는지 assert하는 테스트

    // 간단하다는 장점이 있지만, 테스트 메소드 내부에 assert가 드러나지 않는다.
    @Test(expected = ArithmeticException.class)
    public void checkExceptionByAnnotation() {
        account.throwException();
    }

    // 인지적으로 더 개선되나, 코드가 복잡해진다.
    @Test
    public void checkExceptionByTryCatch() {
        try {
            account.throwException();
            fail(); // Exception이 발생하지 않은 경우 실패시킴
        } catch (ArithmeticException e) {
            assertThat(e.getClass(), equalTo(ArithmeticException.class));
        }
    }

    // Rule을 이용하면 메소드 코드에 expected exception이 인지적으로 드러난다.
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void checkExceptionByRule() {
        thrown.expect(ArithmeticException.class);
        account.throwException();
    }
}