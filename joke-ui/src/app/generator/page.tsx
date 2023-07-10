'use client';
import useSWRImmutable from 'swr/immutable';

 
const fetcher = (url: string) => fetch(url).then((res) => res.json())
 
export default function RandomJoke() {
  const { data, error } = useSWRImmutable('http://localhost:8080/api/v1/joke', fetcher, {
    revalidateIfStale: true,
  })
 
  if (error) return <div>Failed to load</div>
  if (!data) return <div>Loading...</div>
 
  return (
    <div>
      <p>{data.joke}</p>
      <p>{data.punchline}</p>
    </div>
  )
}