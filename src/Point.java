class Point
    {
        Point(int x, int z)
        {
            _X = x;
            _Z = z;
        }

        int _X, _Z;

        public int GetX()
        {
            return _X;
        }

        public int GetZ()
        {
            return _Z;
        }

    }