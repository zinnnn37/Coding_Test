def croatia(w):
    croa = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

    for s in croa:
        w = w.replace(s, '1')
    print(len(w))
        
croatia(input())