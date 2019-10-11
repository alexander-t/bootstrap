<?php

namespace Test;

use PHPUnit\Framework\TestCase;
use SUT\Calculator;

class CalculatorTest extends TestCase
{
    public function testCanBeCreatedFromValidEmailAddress()
    {
        $this->assertEquals(10, Calculator::add(6, 4));
    }
}