import unittest
from hamcrest import *
from hamcrest.core.base_matcher import BaseMatcher
from hamcrest.core.helpers.hasmethod import hasmethod


class MoreThenN(BaseMatcher):
    def __init__(self, n):
        self.n = n  # Monday is 0, Sunday is 6

    def _matches(self, item):
        if self.n > item:
            return False
        return True

    def describe_to(self, description):
        description.append_text("expected > ").append_text(self.n)


def more_then_ten():
    return MoreThenN(10)


def more_then_one():
    return MoreThenN(1)


def years_calc(n, planet):
    d = 0
    if planet == 'Merkury':
        d = 0.2408467
    if planet == 'Wenus':
        d = 0.61519726
    if planet == 'Mars':
        d = 1.8808158
    if planet == 'Jowisz':
        d = 11.862615
    if planet == 'Saturn':
        d = 29.447498
    if planet == 'Uran':
        d = 84.016846
    if planet == 'Neptun':
        d = 164.79132
    if planet == 'Ziemia':
        d = 1
    try:
        if n >= 0:
            return round(n / (31557600 * d), 2)
    except Exception:
        pass
    raise ValueError('Incorrect input')


class TestYearsCalc(unittest.TestCase):
    def test_years_calc_ziemia(self):
        assert_that(years_calc(1000000000, 'Ziemia'), more_then_ten())

    def test_years_calc_wenus(self):
        assert_that(years_calc(1000000000, 'Wenus'),
                    more_then_one())

