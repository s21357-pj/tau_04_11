import unittest
from assertpy import assert_that
from assertpy import add_extension


def is_more_than_ten(self):
    if self.val <= 10:
        return self.error(f'{self.val} is NOT > 10!')
    return self


def is_more_than_one(self):
    if self.val <= 1:
        return self.error(f'{self.val} is NOT > 10!')
    return self


add_extension(is_more_than_ten)
add_extension(is_more_than_one)


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
        assert_that(years_calc(1000000000, 'Ziemia')).is_more_than_ten()

    def test_years_calc_wenus(self):
        assert_that(years_calc(1000000000, 'Wenus')).is_more_than_one()

    def test_years_calc_mars(self):
        assert_that(years_calc(1000000000, 'Mars')).is_more_than_ten()

    def test_years_calc_mars2(self):
        assert_that(years_calc(1000000000, 'Mars')).is_more_than_one()
