package com.myxh.springboot.features;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author MYXH
 * @date 2023/9/23
 */
@SpringBootTest
@DisplayName("一个堆栈")
public class HelloTest
{
    Stack<Object> stack;

    @Test
    @DisplayName("使用 new Stack() 实例化堆栈")
    void isInstantiatedWithNew()
    {
        new Stack<>();
    }

    @Nested
    @DisplayName("当新建时")
    class WhenNew
    {
        @BeforeEach
        void createNewStack()
        {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("为空")
        void isEmpty()
        {
            assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("在弹出时抛出 EmptyStackException 异常")
        void throwsExceptionWhenPopped()
        {
            assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("在查看时抛出 EmptyStackException 异常")
        void throwsExceptionWhenPeeked()
        {
            assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("在推入元素后")
        class AfterPushing
        {

            String anElement = "一个元素";

            @BeforeEach
            void pushAnElement()
            {
                stack.push(anElement);
            }

            @Test
            @DisplayName("它不再为空")
            void isNotEmpty()
            {
                assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("当弹出元素并且为空时返回该元素")
            void returnElementWhenPopped()
            {
                assertEquals(anElement, stack.pop());
                assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("当查看元素时返回该元素，但仍然保持非空")
            void returnElementWhenPeeked()
            {
                assertEquals(anElement, stack.peek());
                assertFalse(stack.isEmpty());
            }
        }
    }
}
